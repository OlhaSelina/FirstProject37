package tests.hws.utils;

import org.testng.annotations.DataProvider;
import tests.hws.dto.UserDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> createNewAccountCSVFile(){
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("src/test/resources/users.csv")));
            line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{new UserDTO().setFirstName(split[0]).setLastName(split[1])
                        .setEmail(split[2]).setPassword(split[3]).setConfirmPassword(split[4])});
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
