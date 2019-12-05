import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTestingWithRestAssured {
    @Test
    public void getData(){
        given().
                when()
                .get("https://www.food2fork.com/api/search?key=e676ea4152b2077f7e7bef634e232fff").
                then()
                .assertThat().statusCode(200)
                .and()
                .assertThat().contentType(ContentType.HTML);
    }

}



