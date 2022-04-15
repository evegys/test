package kg.itschool.megacom.dao;

public abstract class DaoContext {

    static {
        try {
            System.out.println("Loading driver...");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver loading failed");
            e.printStackTrace();
        }
    }

    private static MentorDao mentorDao;

    public static CrudDao<?> autowired(String qualifier, String scope) {
        if (!scope.equals("singleton") && !scope.equals("prototype")) {
            throw new RuntimeException("Invalid scope of bean " + scope);
        }
        switch (qualifier) {

            case "MentorDao":
                return getMentorDaoSQL(scope);

            default:
                throw new RuntimeException("Can not find bean for autowiring: " + qualifier);
        }
    }

    private static MentorDao getMentorDaoSQL(String scope) {
        if (scope.equals("prototype")) {
            return new MentorDaoImpl();
        }
        if (mentorDao == null) {
            mentorDao = new MentorDaoImpl();
        }
        return mentorDao;
    }
}
