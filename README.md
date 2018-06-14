#geolocation-converter

Aims to provide a lightweight utility library that converts Coordinated Universal Time to Local Time given the coordinates.

The library contains a reference to a TimeZone data store which includes information like Zone ID and its coordinates. It determines the "right" TimeZone by identifying the closest zone to the given coordinates. Yes, this may not produce accurate results but it still works most of the time. Alternatively, if you are looking for accuracy, try to check https://github.com/Alterplay/APTimeZones where I got the TimeZone data store.

