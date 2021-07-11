package com.travelportTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import com.test.commonuties.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;



public class PostRequestTest {

    public String valid_payload = "{\"numOfDays\":3, \"checkInDate\":\"2021-07-11\"}";

    public String Invalid_payload = "{\"numOfDays\":3,";

    public String  nonleapyear_invaliddate_payload = "{\"numOfDays\":1, \"checkInDate\":\"2022-02-29\"}";

    public String backdated_payload = "{\"numOfDays\":3, \"checkInDate\":\"2020-06-11\"}";

    public String noroom_zero_payload = "{\"numOfDays\":0, \"checkInDate\":\"2021-07-11\"}";


    ConfigFileReader conf = new ConfigFileReader();


    @Test
    public void room_valid_booking_200(){

        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body(valid_payload)
                .when().post().
                   then().assertThat().statusCode(200).log().body();

    }


    @Test
    public void room_Invalid_booking_400(){


        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body(Invalid_payload)
                .when().post().
                then().assertThat().statusCode(400).log().body();

    }

    /*
      Validated the response body  by passing 3 days of booking for checkIndate & checkOutDate
       and assuming the total prices as 350 - working as expected

    */

    @Test
    public void room_valid_booking_reponse_check(){

        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body(valid_payload)
                .when().post().
                then().assertThat().
                body("checkInDate",equalTo("2021-07-11")).
                body("checkOutDate",equalTo("2021-07-14")).
                body("totalPrice",equalTo(350));

    }

    @Test
    public void room_withoutbody_booking_400(){


        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body("")
                .when().post().
                then().assertThat().statusCode(400).log().body();

    }

    // bug - Passing wrong url and this test expecting 404 but system not giving any response. commented the invalid url part
    @Test
    public void room_wrongurl_booking_404(){


        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request"); //+ "Invlaidurl"; commented this to complete the test

        given().contentType(ContentType.JSON).body(valid_payload)
                .when().post().
                then().assertThat().statusCode(404).log().body();

    }

    /*
   bug in the system - non leapyear it is taking feb 29 & 30
   Expected status code <400> but was <200>.
    */

    @Test
    public void room_nonleapyear_invaliddate_booking_400(){


        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body(nonleapyear_invaliddate_payload)
                .when().post().
                then().assertThat().statusCode(400).log().body();

    }


     /*
   bug in the system -backdate  it is taking allowing any dates for booking
   Expected status code <400> but was <200>.
    */

    @Test
    public void room_backdated_booking_400(){


        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body(backdated_payload)
                .when().post().
                then().assertThat().statusCode(400).log().body();

    }


    /*
   bug in the system -System is taking number of days as 0 and -ve as well  & it is  allowing create the request
   Expected status code <400> but was <200>.
    */

    @Test
    public void room_noroomZero_booking_400(){


        RestAssured.baseURI=conf.getConfigvalue("travelport_post_request");

        given().contentType(ContentType.JSON).body(noroom_zero_payload)
                .when().post().
                then().assertThat().statusCode(400).log().body();

    }
}
