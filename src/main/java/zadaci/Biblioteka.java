package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Knjiga;
import model.Oblast;

import java.sql.SQLException;
import java.util.List;

public class Biblioteka {
    static Dao<Knjiga,Integer> knjigaDao;
    static Dao<Oblast,Integer> oblastDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
            knjigaDao = DaoManager.createDao(connectionSource,Knjiga.class);
            oblastDao = DaoManager.createDao(connectionSource,Oblast.class);

            List<Knjiga> knjige = knjigaDao.queryForAll();
            Knjiga k1 = (Knjiga) knjige.get(0);
            k1.prisutna = true;
            Knjiga k2 = (Knjiga) knjige.get(1);
            k2.prisutna = true;

            KnjigaNit k11 = new KnjigaNit("Mika",k1);
            k11.start();
            KnjigaNit k12 = new KnjigaNit("Dada",k1);
            k12.start();
            KnjigaNit k13 = new KnjigaNit("Aca",k1);
            k13.start();
            KnjigaNit k21 = new KnjigaNit("Strale",k2);
            k21.start();
            KnjigaNit k22 = new KnjigaNit("Mladen",k2);
            k22.start();
            KnjigaNit k23 = new KnjigaNit("Eva",k2);
            k23.start();


            try {
                k11.join();
                k12.join();
                k13.join();
                k21.join();
                k22.join();
                k23.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Biblioteka se zatvorila.");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
