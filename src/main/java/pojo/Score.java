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

public class Score extends Data {
  private String name;
  private Integer score;

  @Override
  public List<Score> getData() {
    return Arrays.asList(
        new Score("Test user", 78)
    );
  }

  @Override
  public String getJSON() {
    StringBuilder json = new StringBuilder("[\n");
    List<Score> scoreList = getData();
    for (Score sc : scoreList) {
      json.append("{\n");
      json.append("\"name\":\"");
      json.append(sc.name);
      json.append("\",\n");
      json.append("\"score\":");
      json.append(sc.score);
      json.append("\n");
      json.append("},\n");
    }
    json.deleteCharAt(json.length()-2);
    json.append("]");
    return json.toString();
  }

  @Override
  public String getXML() {
    StringBuilder xml = new StringBuilder("<Scores>\n");
    List<Score> scoreList = getData();
    for (Score sc : scoreList) {
      xml.append("<Score>\n");
      xml.append("<name>" + sc.name + "</name>\n");
      xml.append("<score>" + sc.score + "</score>\n");
      xml.append("</Score>\n");
    }
    xml.append("</Scores>");
    return xml.toString();
  }
}
