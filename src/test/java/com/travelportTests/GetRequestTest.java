package com.travelportTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import com.test.commonuties.ConfigFileReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import sun.jvm.hotspot.types.CIntegerType;

import javax.xml.ws.Response;


public class GetRequestTest {

    public String valid_date = "2021-07-12";
    public String Invalid_date_formate = "07-12_2021";
    public String nonleapyear_date_formate = "2022-02-29";
    public String backdated_date = "2020-06-12";
    public String valid_date_checkroom = "2021-07-20";

    ConfigFileReader conf = new ConfigFileReader();

    @Test
    public void room_avalibility_valid_date_200(){


        /*
          Reading the base url from config file
          this test is expecting success 200 status code and working fine
        */

        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+valid_date;

        given().
                when().get().
                            then().assertThat().statusCode(200).log().body();
    }



    @Test
    public void room_avalibility_badrequest_400(){

        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+"invalidurl";

        given().
                when().get().
                then().assertThat().statusCode(400).log().body();
    }

    @Test
    public void room_avalibility_invalid_date_formate_400(){

        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+Invalid_date_formate;
        given().
                when().get().
                then().assertThat().statusCode(400).log().body();
    }

    /*
     Validated response body assuming that we have 10 room available &
     price is 130
    */
    @Test
    public void room_avalibility_validate_responsecheck(){


        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+valid_date_checkroom;

        given().
                when().get().
                then().assertThat().
                body("date" , equalTo("2021-07-20")).
                body("rooms_available" , equalTo(10)).
                body("price" , equalTo(130));

    }

    /*
        bug in the system -
        this test is expecting room avalabilty > 0 but getting -ve values and failing with assert
      */

    @Test
    public void room_avalibility_validate_roomgreater_then_Zero_200(){


        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+valid_date;

        given().
                when().get().
                then().assertThat().
                body("rooms_available" , greaterThanOrEqualTo(0));

    }

    /*
    bug in the system - non leapyear it is taking feb 29 & 30
    Expected status code <400> but was <200>.
     */

    @Test
    public void room_avalibility_nonleapyear_400(){


        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+nonleapyear_date_formate;
        given().
                when().get().
                then().assertThat().statusCode(400).log().body();
    }

    /*
   bug in the system - backdated_date 2020-06-12
   Expected status code <400> but was <200>.

    */

    @Test
    public void room_avalibility_backdated_400(){


        RestAssured.baseURI = conf.getConfigvalue("travelport_get_request")+backdated_date;
        given().
                when().get().
                then().assertThat().statusCode(400).log().body();
    }


}
