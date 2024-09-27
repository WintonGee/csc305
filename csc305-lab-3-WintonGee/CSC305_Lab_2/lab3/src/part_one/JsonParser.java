package part_one;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class JsonParser {

    private final JSONObject jsonData;

    JsonParser(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    // Return the person's name
    String getName() throws JSONException {
        return jsonData.getString("name");
    }

    // Return the person's Known For
    List<String> getKnownFor() throws JSONException {
        List<String> knownFor = new ArrayList<>();
        JSONArray jsonKnownFor = jsonData.getJSONArray("knownFor");
        for (int i = 0; i < jsonKnownFor.length(); i++)
            knownFor.add(jsonKnownFor.getString(i));
        return knownFor;
    }

    // Return the person's awards
    List<Award> getAwards() throws JSONException {
        List<Award> awards = new ArrayList<>();
        JSONArray jsonAwards = jsonData.getJSONArray("awards");
        for (int i = 0; i < jsonAwards.length(); i++) {
            JSONObject jsonAward = jsonAwards.getJSONObject(i);
            String awardName = jsonAward.getString("name");
            int awardYear = jsonAward.getInt("year");
            awards.add(new Award(awardName, awardYear));
        }
        return awards;
    }

}
