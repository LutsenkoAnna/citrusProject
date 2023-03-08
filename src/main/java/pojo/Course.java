
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
public class Course extends Data {

  private String name;
  private Integer price;

  @Override
  public List getData() {
    return Arrays.asList(
        new Course("QA java", 15000),
        new Course("QA python", 10000)
    );
  }

  @Override
  public String getJSON() {
    StringBuilder json = new StringBuilder("[\n");
    List<Course> courseList = getData();
    for (Course course : courseList) {
      json.append("{\n");
      json.append("\"name\":\"");
      json.append(course.name);
      json.append("\",\n");
      json.append("\"price\":");
      json.append(course.price);
      json.append("\n");
      json.append("},\n");
    }
    json.deleteCharAt(json.length()-2);
    json.append("]");
    return json.toString();
  }

  @Override
  public String getXML() {
    StringBuilder xml = new StringBuilder("<Courses>\n");
    List<Course> courseList = getData();
    for (Course course : courseList) {
      xml.append("<Course>\n");
      xml.append("<name>" + course.name + "</name>\n");
      xml.append("<price>" + course.price + "</price>\n");
      xml.append("</Course>\n");
    }
    xml.append("</Courses>");
    return xml.toString();
  }
}
