#Simple API Test After Lunch

1.Start API Server
> ./gradlew bootRun

2.Call Post API
> <http://localhost:8084/inventories>

With example Data

```json
{
    "id": 1,
    "sku": "iPhone X 64G 黑色",
    "warehouse": "成都仓",
    "currentQuantity": 100,
    "lockedQuantity": 0,
    "availableQuantity": 100
}
```

3.Get all inventories, GET API
> <http://localhost:8084/inventories>

4.Get inventory by SKU, GET API
> <http://localhost:8084/inventories/iPhone%20X%2064G%20%E9%BB%91%E8%89%B2>

5.Lock inventory, PUT API
> <http://localhost:8084/inventories/lock>
With example data
```
{
	"sku": "iPhone X 64G 黑色",
	"quantity": 1
}
```

6.Unlock inventory, PUT API
> <http://localhost:8084/inventories/unlock>

With example data:
```
{
	"sku": "iPhone X 64G 黑色",
	"quantity": 1
}
```

7.Deduct inventory, PUT API
> http://localhost:8084/inventories/deduct

With example data:

```
{
	"sku": "iPhone X 64G 黑色",
	"quantity": 1
}
```