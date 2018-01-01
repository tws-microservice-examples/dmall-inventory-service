package inventory

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name('Should get a product')
            request {
                method GET()
                url ('/inventories/aaaa-bbbb-cccc')
            }
            response {
                status 200
                body("""
                    {
                        "id": 1,
                        "sku": "aaaa-bbbb-cccc",
                        "warehouse": "A1",
                        "currentQuantity": 10000,
                        "availableQuantity": 9900
                    }
                """)
                testMatchers {
                    jsonPath('$.id', byRegex(number()))
                }
            }

        },
]