package hw;

import behavior.http.GetDataBehavior;
import behavior.http.MockBehavior;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.Course;
import pojo.Score;
import pojo.User;

public class HTTP_Test extends TestNGCitrusTestRunner {

  private TestContext context;
  @BeforeTest
  public void setUp(){
    this.context = citrus.createTestContext();
  }

  @Test(description = "/user/get/{id} - получение оценки пользователя", enabled=true)
  @CitrusTest
  public void getScore() {
    applyBehavior(new GetDataBehavior(context, "/user/get/1"));
    applyBehavior(new MockBehavior(context, new Score()));

    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .jsonSchema("scoreSchemaJSON")
        .schemaValidation(true)
    );
  }

  @Test(description = "/course/get/all - для получения списка курсов", enabled=true)
  @CitrusTest
  public void getCourse() {
    applyBehavior(new GetDataBehavior(context, "/course/get/all"));
    applyBehavior(new MockBehavior(context, new Course()));

    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .jsonSchema("courseSchemaJSON")
        .schemaValidation(true)
    );
  }

  @Test(description = "/user/get/all - для получения списка всех пользователей", enabled=true)
  @CitrusTest
  public void getUser() {

    applyBehavior(new GetDataBehavior(context, "/user/get/all"));
    applyBehavior(new MockBehavior(context, new User()));

    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .receive()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .jsonSchema("userSchemaJSON")
        .schemaValidation(true)
    );
  }
}
