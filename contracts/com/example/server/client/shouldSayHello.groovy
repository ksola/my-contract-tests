org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/managed/forenames?match=Krystian Sola'
    }
    response {
        status 200
        body("""
{
  "page": 0,
  "pageSize": 0,
  "numberOfPages": 0,
  "total": 0,
  "values": [
    {
      "value": "krystian"
    }
  ]
}
""")
    }
}