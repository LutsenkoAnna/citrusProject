package hw;

import behavior.soap.GetDataBehavior;
import behavior.soap.MockBehavior;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.message.MessageType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.*;

public class SOAP_Test extends TestNGCitrusTestRunner {

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

    soap(soapActionBuilder -> soapActionBuilder
        .client("soapClient")
        .receive()
        .messageType(MessageType.XML)
        .validate("Scores/Score/name", "Test user")
        .validate("Scores/Score/score", 78)
    );
  }

  @Test(description = "/course/get/all - для получения списка курсов", enabled=true)
  @CitrusTest
  public void getCourse() {
    applyBehavior(new GetDataBehavior(context, "/course/get/all"));
    applyBehavior(new MockBehavior(context, new Course()));

    soap(soapActionBuilder -> soapActionBuilder
        .client("soapClient")
        .receive()
        .messageType(MessageType.XML)
        .validate("Courses/Course[2]/name", "QA python")
        .validate("Courses/Course[2]/price", 10000)
    );
  }

  @Test(description = "/user/get/all - для получения списка всех пользователей", enabled=true)
  @CitrusTest
  public void getUser() {

    applyBehavior(new GetDataBehavior(context, "/user/get/all"));
    applyBehavior(new MockBehavior(context, new User()));

    soap(soapActionBuilder -> soapActionBuilder
        .client("soapClient")
        .receive()
        .messageType(MessageType.XML)
        .validate("Users/User[1]/name", "Test user")
        .validate("Users/User[1]/email", "test@test.test")
    );
  }
}
