
package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.Arrays;
import java.util.List;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Data {

  private Integer id;
  private Integer age;
  private String course;
  private String email;
  private String name;

  @Override
  public List getData() {
    return Arrays.asList(
        new User(1, 23, "QA", "test@test.test", "Test user")
    );
  }

  @Override
  public String getJSON() {
    StringBuilder json = new StringBuilder("[\n");
    List<User> userList = getData();
    for (User user : userList) {
      json.append("{\n");
      json.append("\"id\":");
      json.append(user.id);
      json.append(",\n");
      json.append("\"name\":\"");
      json.append(user.name);
      json.append("\",\n");
      json.append("\"course\":\"");
      json.append(user.course);
      json.append("\",\n");
      json.append("\"email\":\"");
      json.append(user.email);
      json.append("\",\n");
      json.append("\"age\":");
      json.append(user.age);
      json.append("\n");
      json.append("},\n");
    }
    json.deleteCharAt(json.length()-2);
    json.append("]");
    return json.toString();
  }

  @Override
  public String getXML() {
    StringBuilder xml = new StringBuilder("<Users>\n");
    List<User> userList = getData();
    for (User user : userList) {
      xml.append("<User>\n");
      xml.append("<id>" + user.id + "</id>\n");
      xml.append("<name>" + user.name + "</name>\n");
      xml.append("<course>" + user.course + "</course>\n");
      xml.append("<email>" + user.email + "</email>\n");
      xml.append("<age>" + user.age + "</age>\n");
      xml.append("</User>\n");
    }
    xml.append("</Users>");
    return xml.toString();
  }
}
