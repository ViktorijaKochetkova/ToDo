package com.todoproject2jdbc.todo;

import java.sql.*;
import java.util.ArrayList;

public class TodoRepository {

    public TodoRepository() {
    }

    public void createTodo(Todo todo) {
        String query = "INSERT INTO todos(description, isComplete) VALUES(?,?)";

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1,todo.getDescription());
            statement.setBoolean(2,todo.isComplete());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }
        public ArrayList<Todo> finAllTodos(){
            ArrayList<Todo> todoList = new ArrayList<>();
            String query = "SELECT * FROM todos";

            try {
                PreparedStatement statement = getConnection().prepareStatement(query);
                ResultSet result = statement.executeQuery();

                while (result.next()){
                    todoList.add(new Todo(
                        result.getInt( "id"),
                        result.getString( "description"),
                        result.getBoolean( "isComplete"),
                        result.getTimestamp( "createdAt"),
                        result.getTimestamp( "updatedAt")
                    ));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return todoList;
        }
        private Connection getConnection () {
        String username = "root";
        String password = "Vas!l1sa";
        String database = "spring_todo";

        String url = "jdbc:mysql://localhost:3306/"+database;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();

        }

        return connection;
    }


    public void deleteTodoItem(Integer todoId) {
        String query ="DELETE FROM todos WHERE id = ?";
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(query);
            statement.setInt(1, todoId);
            statement.executeUpdate();

        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void updateTodoStatus(int todoId) {
        String query = "UPDATE todos SET isComplete = true WHERE id = ?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1,todoId);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }
}