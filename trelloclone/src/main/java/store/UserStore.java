package store;

import enitites.User;
import java.util.HashMap;
import java.util.Map;

public class UserStore {
   Map<String, User> userMap = new HashMap<>();
   private static UserStore userStore = new UserStore();

   private UserStore() {

   }

   public static UserStore getInstance() {
       return userStore;
   }

   public void addUser(User user) {
       userMap.put(user.getId(), user);
   }

   public User getUser(String id) {
       return userMap.get(id);
   }
}
