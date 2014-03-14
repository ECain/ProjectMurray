package project.murray.json;

import android.view.View;

import com.esri.core.map.Field;

/**
 * POJO for storing the data associated with a row in the attributes list
 */
public class AttributeItem {
  private Field field;
  private Object value;
  private View view;

  public View getView() {
    return view;
  }

  public void setView(View view) {
    this.view = view;
  }

  public Field getField() {
    return field;
  }

  public void setField(Field field) {
    this.field = field;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

}