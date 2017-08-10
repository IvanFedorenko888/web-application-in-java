package ru.fedorenko.Mybatis;

/**
 * Created by ivan on 23.06.17.
 */
        import org.apache.ibatis.io.Resources;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.apache.ibatis.session.SqlSessionFactoryBuilder;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.Reader;

public class Mybatis {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-conf.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static SqlSessionFactory getFactory(){
        return sqlSessionFactory;
    }
}
