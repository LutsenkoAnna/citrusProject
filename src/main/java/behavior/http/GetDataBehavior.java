package behavior.http;

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
    http(httpActionBuilder -> httpActionBuilder
        .client("restClient")
        .send()
        .get(this.path)
        .fork(true)
    );
  }
}
