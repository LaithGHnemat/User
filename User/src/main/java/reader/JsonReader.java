package reader;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.java.Log;


import model.User;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@Log
public class JsonReader implements FileReader{

    public  List<User> getUsers() throws IOException {
        log.info("Invoking getUsers method in class JsonReader");
        InputStream inputStream = Resources.getResource("user.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

}
