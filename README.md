## weatherService
**Test API weather service**

**В приложении использовались:**   
API погодных сервисов: **OpenWeather** и **WeatherStack**.  
База данных: **PostgresQL**  
Java framework: **Spring boot**  

Приложение выдает информацию о погоде в виде **Json** на **Get** запрос по следующим адресам:    
**localhost:8080/api/openWeather/{city}** - прогноз погоды от сервиса **OPENWEATHER** для выбранного города. Запись в БД не ведется    
_Пример запроса: localhost:8080/api/openWeather/Moscow_  

**localhost:8080/api/stackWeather/{city}** - прогноз погоды от сервиса **WEATHERSTACK** для выбранного города. Запись в БД не ведется    
_Пример запроса: localhost:8080/api/stackWeather/Chelyabinsk_

**localhost:8080/api/{city}/{service}** - прогноз погоды по выбранному городу через нужный сервис. При данном запросе, ведется запись и выдача прогноза погоды через базу данных.    
_Пример запроса: localhost:8080/api/Saratov/openWeather_

