package behavior.soap;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import com.consol.citrus.message.MessageType;
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

    soap(soapActionBuilder -> soapActionBuilder
        .server("soapServer")
        .receive()
    );

    soap(soapActionBuilder -> soapActionBuilder
        .server("soapServer")
        .send()
        .messageType(MessageType.XML)
        .payload(data.getXML())
    );
  }
}