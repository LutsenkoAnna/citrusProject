package behavior.soap;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.AbstractTestBehavior;

public class GetDataBehavior extends AbstractTestBehavior {

  private TestContext context;
  public String path;

  public GetDataBehavior(TestContext context, String path) {
    this.context = context;
    this.path = path;
  }

  @Override
  public void apply() {
    soap(soapActionBuilder -> soapActionBuilder
        .client("soapClient")
        .send()
        .fork(true)
    );
  }
}
