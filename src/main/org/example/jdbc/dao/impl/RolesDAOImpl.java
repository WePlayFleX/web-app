package org.example.jdbc.dao.impl;

import org.example.jdbc.dao.AbstactDAO;
import org.example.model.Role;
import org.example.model.User;
import org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RolesDAOImpl extends AbstactDAO<Role> {
    @Override
    public boolean create(Role role) {
        return false;
    }

    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public boolean delete(Role role) {
        return false;
    }

    @Override
    public Role getById(Role role) {
        final String select = "SELECT * FROM crazy_app_db.ROLES WHERE id = " + role.getId();
        Connection conn = DBUtils.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            if (rs.next()){
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("desc"));
            } else {
                System.out.println("Role Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeConnection(conn);
        }
        return role;
    }

    @Override
    public Set<Role> getAll() {
        return null;
    }


    public Set<Role> getAllRolesByUser(User user){
       Set<Role> userRoles = new HashSet<>();

        final String select = "SELECT U.user_id, U.role_id, R.name, R.descr  FROM  users_roles U " +
                "INNER JOIN roles R ON U.role_id = R.id WHERE U.user_id =  " + user.getId();

        try (Connection conn = DBUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(select)){
            while (rs.next()){
              int roleID = rs.getInt("role_id");
              String name = rs.getString("name");
              String descr = rs.getString("descr");
              userRoles.add(new Role(roleID, name, descr));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return userRoles;
    }


}
