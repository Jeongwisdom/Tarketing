package com.wisdom.tarketing.test_support;

import jakarta.persistence.EntityManager;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseCleanup implements InitializingBean {

    private final List<String> tableNames = new ArrayList<>();
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EntityManager entityManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables("tarketing", null, null, new String[]{"TABLE"});
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            tableNames.add(tableName);
        }
    }

    @Transactional
    public void execute() {
        entityManager.flush();
        for (String tableName : tableNames) {
            entityManager.createNativeQuery(String.format("TRUNCATE TABLE `%s`", tableName)).executeUpdate();
            entityManager.createNativeQuery(String.format("ALTER TABLE %s AUTO_INCREMENT = 1", tableName))
                    .executeUpdate();
        }
    }
}
