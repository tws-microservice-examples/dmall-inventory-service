package inventory

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name('Should get a product')
            request {
                method GET()
                url ('/inventories/6009907')
                headers {
                    header('''Content-Type''', '''application/json;charset=UTF-8''')
                }
            }
            response {
                status 200
                headers {
                    header('''Content-Type''', '''application/json;charset=UTF-8''')
                }
                body("""
                    {
                        "id": 1,
                        "sku": "6009907",
                        "warehouse": "北京仓",
                        "currentQuantity": 100,
                        "lockedQuantity": 0,
                        "availableQuantity": 100
                    }
                """)
                testMatchers {
                    jsonPath('$.id', byRegex(number()))
                    jsonPath('$.lockedQuantity', byRegex(number()))
                    jsonPath('$.availableQuantity', byRegex(number()))
                }
            }
        },

        Contract.make {
            name('Should return product when post a lock event')
            request {
                method POST()
                url ('/inventories/6009907/lockEvents')
                headers {
                    header('''Content-Type''', '''application/json;charset=UTF-8''')
                }
                body("""
                    {
                        "sku": "6009907",
                        "quantity": 1
                    }
                """)
            }
            response {
                status 201
                headers {
                    header('''Content-Type''', '''application/json;charset=UTF-8''')
                }
                body("""
                    {
                        "id": 1,
                        "sku": "6009907",
                        "warehouse": "北京仓",
                        "currentQuantity": 100,
                        "lockedQuantity": 1,
                        "availableQuantity": 99
                    }
                """)
                testMatchers {
                    jsonPath('$.id', byRegex(number()))
                }
            }
        }
]