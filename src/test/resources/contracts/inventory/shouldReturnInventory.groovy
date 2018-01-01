package inventory

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name('Should get a product')
            request {
                method GET()
                url ('/inventories/6009907')
            }
            response {
                status 200
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
                }
            }
        },
]