package behavior.http;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;
import pojo.Data;

public class MockBehavior extends AbstractTestBehavior {
  private TestContext context;
  private Data data;

  public MockBehavior(TestContext context, Data data) {
    this.context = context;
    this.data = data;
  }

  @Override
  public void apply() {

    http(httpActionBuilder -> httpActionBuilder
        .server("restServer")
        .receive()
        .get()
    );

    http(httpActionBuilder -> httpActionBuilder
        .server("restServer")
        .send()
        .response(HttpStatus.OK)
        .messageType(MessageType.JSON)
        .payload(data.getJSON())
    );
  }
}