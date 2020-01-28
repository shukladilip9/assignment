# assignment
This project is maven based and contains following test cases :
ArithmeticCalculation class unit cases---Used TestNg for unit test cases.
Searching Least Expensive Apartment in Dubai marina with defined criteria. Used Selenium 3/Java8/TestNg/Log4j
Note:Script is tested at mac os 10.14.6 with chrome browser v 72
Verifying location entered is same as server response..Used Apache HttpClient Library/Jackson Mapper/log4j/TestNg/Java8


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">

	<test name="FunctionalTest">
		<classes>


			<class name="api.test.LocationVerificationTest" />
			<class
				name="least.expensive.hotel.SearchLeastExpensiveApartmentTest" />
			<class name="unit.arithmetic.test.ArithmeticCalculationTest" />



		</classes>
	</test> <!-- Test -->
</suite> <!-- Suite -->

Displaying logs for all the three test cases :

Starting ChromeDriver 74.0.3729.6 (255758eccf3d244491b8a1317aa76e1ce10d57e9-refs/branch-heads/3729@{#29}) on port 7032
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jan 28, 2020 9:29:04 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
2020-01-28 21:29:04 INFO  TestBase:55 - Browser is being maximized
2020-01-28 21:29:04 INFO  LocationVerificationTest:32 - Creating http client instance
2020-01-28 21:29:04 INFO  LocationVerificationTest:34 - Formation of URI
2020-01-28 21:29:04 INFO  LocationVerificationTest:38 - URI is https://maps.googleapis.com/maps/api/place/textsearch/json?query=dubai&key=AIzaSyBWnICQGYkk1kCCLxQqwqQ5unr_vf1s6xY
2020-01-28 21:29:04 INFO  LocationVerificationTest:40 - Instance of HttpGet
2020-01-28 21:29:04 INFO  LocationVerificationTest:42 - Executing the request
2020-01-28 21:29:05 INFO  LocationVerificationTest:45 - Verifying status code 200
2020-01-28 21:29:05 INFO  LocationVerificationTest:50 - response body : {
   "html_attributions" : [],
   "results" : [
      {
         "formatted_address" : "Dubai - United Arab Emirates",
         "geometry" : {
            "location" : {
               "lat" : 25.2048493,
               "lng" : 55.2707828
            },
            "viewport" : {
               "northeast" : {
                  "lat" : 25.3585607,
                  "lng" : 55.5650393
               },
               "southwest" : {
                  "lat" : 24.7921359,
                  "lng" : 54.89045429999999
               }
            }
         },
         "icon" : "https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png",
         "id" : "4517501182432a6539985e4dbd00278179f70a98",
         "name" : "Dubai",
         "photos" : [
            {
               "height" : 1743,
               "html_attributions" : [
                  "\u003ca href=\"https://maps.google.com/maps/contrib/105303505373661530610\"\u003eHauser Quaid Zzyzx\u003c/a\u003e"
               ],
               "photo_reference" : "CmRaAAAAKUl4I5NYbcs4ShTDI2ANy3e5BbT-HZ0HJ0IQ9-T7c3wxttiPp4GFTErkEJdQdnQ_KTXjM32ghhx2glI4a_oZgkVyBA_CykTpdonVmQ1oRG2A3GVCl3WAPJsFAblQg2kxEhAvzrEWDh78BZtvLjkDphJHGhRVhCRe8NICD2vC-glPxsCq7JQwZg",
               "width" : 1080
            }
         ],
         "place_id" : "ChIJRcbZaklDXz4RYlEphFBu5r0",
         "reference" : "ChIJRcbZaklDXz4RYlEphFBu5r0",
         "types" : [ "locality", "political" ]
      }
   ],
   "status" : "OK"
}

2020-01-28 21:29:05 INFO  LocationVerificationTest:51 - Verifying entered location belongs to Dubai with lattitude and longitude basis
2020-01-28 21:29:05 INFO  LocationVerificationTest:52 - Parsing Json response in java pojo
2020-01-28 21:29:05 INFO  SearchLeastExpensiveApartmentTest:26 - Configutaion is loaded
2020-01-28 21:29:05 INFO  SearchLeastExpensiveApartmentTest:27 - Opening URL : https://www.propertyfinder.ae
2020-01-28 21:29:23 INFO  SearchLeastExpensiveApartmentTest:30 - Selecting Property Type:Rent
2020-01-28 21:29:24 INFO  SearchLeastExpensiveApartmentTest:36 - Selecting Min BedRooms: 2
2020-01-28 21:29:24 INFO  SearchLeastExpensiveApartmentTest:44 - Seraching property in Dubai marina for rent with min 2 bedrooms
2020-01-28 21:29:27 INFO  SearchLeastExpensiveApartmentTest:50 - Results are fetching out
2020-01-28 21:29:28 INFO  SearchLeastExpensiveApartmentTest:82 - Price of  Least Expensive property for rent with min 2 Bed Rooms is 76900
2020-01-28 21:29:28 INFO  SearchLeastExpensiveApartmentTest:89 - 1 Radiant 2-BR Apartment With Marina Views
2020-01-28 21:29:28 INFO  SearchLeastExpensiveApartmentTest:94 - Number of Property founds at  price 76900 is 1
2020-01-28 21:29:28 INFO  SearchLeastExpensiveApartmentTest:96 - property description or title are :
2020-01-28 21:29:28 INFO  SearchLeastExpensiveApartmentTest:99 - 1 Radiant 2-BR Apartment With Marina Views
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 45.04 sec - in TestSuite

Results :

Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

