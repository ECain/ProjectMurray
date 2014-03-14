package project.murray.online;

import java.util.HashMap;
import java.util.List;


import android.content.Context;
import android.widget.ArrayAdapter;

public class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> _IdHashMap = new HashMap<String, Integer>();

    public StableArrayAdapter(Context context, int textViewResourceId,
        List<String> objects) {
      super(context, textViewResourceId, objects);
      for (int i = 0; i < objects.size(); ++i) {
        _IdHashMap.put(objects.get(i), i);
      }
    }

    @Override
    public long getItemId(int position) {
      String item = getItem(position);
      return _IdHashMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
      return true;
    }

  }
