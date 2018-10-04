Use the below Linux commands to use the web service: <br />
---
**1)Create offer(Example below, for duration minutes, hours, days and weeks are supported): <br />**
    -curl -i -H "Content-Type: application/json" -X POST -d '{ <br />
        "title": "Offer",<br />
        "description": "Description",<br />
        "currency": "GBP",<br />
        "price": 20,<br />
        "duration": "1 minute"<br />
    }' localhost:8080/offer<br />
**2)Delete/Cancel offer:<br />**
    -curl -i -H "Content-Type: application/json" -X DELETE localhost:8080/offer/{id of offer you want to delete}<br />
**3)Show all offers:<br />**
    -curl -i -H "Content-Type: application/json" -X GET localhost:8080/offers<br />
**4)Show ongoing offers:<br />**
    -curl -i -H "Content-Type: application/json" -X GET localhost:8080/ongoing<br />
**5)Show expired offers:<br />**
    -curl -i -H "Content-Type: application/json" -X GET localhost:8080/expired<br />

