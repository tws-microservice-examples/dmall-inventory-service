package inventory

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name('Should get a product')
            request {
                method GET()
                url ('/inventories/iPhone%20X%2064G%20%E9%BB%91%E8%89%B2')
            }
            response {
                status 200
                body("""
                    {
                        "id": 1,
                        "sku": "iPhone X 64G 黑色",
                        "warehouse": "成都仓",
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