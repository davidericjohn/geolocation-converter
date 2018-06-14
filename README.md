 # geolocation-converter

Aims to provide a lightweight utility library that converts Coordinated Universal Time to Local Time given the coordinates.

The library contains a reference to a TimeZone data store which includes information like Zone ID and its coordinates. It determines the "right" TimeZone by identifying the closest zone to the given coordinates. Yes, this may not produce the most accurate results but will still work most of the time. Alternatively, if you are looking for accuracy, try to check https://github.com/Alterplay/APTimeZones where I got the TimeZone data store.

# Usage
```
GeoLocationConverter converter = new GeoLocationConverterImpl();
ZonedDateTime zonedDateTime = converter.getZonedDateTime("2018-06-10T02:52:49Z", -36.848448, 174.7600023);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz");

#print result
System.out.println(zonedDateTime.format(formatter));
System.out.println(zonedDateTime.getZone());
```

### Result
```
2018-06-10T14:52:49NZST
Pacific/Auckland
```
