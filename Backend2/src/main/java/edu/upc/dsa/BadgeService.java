package edu.upc.dsa;
import edu.upc.dsa.models.Badge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadgeService {
    private static Map<Integer, List<Badge>> userBadges = new HashMap<>();

    static {
        // Datos iniciales
        List<Badge> badgesForUser1 = new ArrayList<>();
        badgesForUser1.add(new Badge("Millor del món", "https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png"));
        badgesForUser1.add(new Badge("El més llest", "https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png"));
        userBadges.put(1, badgesForUser1);

        List<Badge> badgesForUser2 = new ArrayList<>();
        badgesForUser2.add(new Badge("Expert en programació", "https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png"));
        userBadges.put(2, badgesForUser2);
    }

    public List<Badge> getUserBadges(int userId) {
        return userBadges.getOrDefault(userId, new ArrayList<>());
    }
}
