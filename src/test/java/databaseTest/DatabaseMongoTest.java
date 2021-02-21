package databaseTest;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatabaseMongoTest {

    MongoClient mongoClient=null;
    MongoDatabase db=null;

    @BeforeClass
    public void beforeClass(){
        try{
            mongoClient = new MongoClient("localhost",27017);
            db = mongoClient.getDatabase("users");
            System.out.println("Database connection created");
        }
        catch (Exception e){
            System.err.println("Unable to create connection");
        }
    }

    @Test
    public void test() {
        try{
            MongoCollection<Document> table = db.getCollection("userData");
            //BasicDBObject searchQuery = new BasicDBObject();
            //searchQuery.put("user","Himanshu");searchQuery
            FindIterable<Document> cursor = table.find();
            for(Document obj : cursor){
                //System.out.println(obj.toString());
                String lastName = obj.getString("user");
                System.out.println(lastName);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
