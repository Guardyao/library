import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Book> LIST;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
            load();
            while (true) {
                System.out.println("欢迎来到图书管理系统");
                System.out.println("选择你要进行的操作(输入数字)");
                System.out.println("1.录入书籍");
                System.out.println("2.查询书籍");
                System.out.println("3.修改书籍");
                System.out.println("4.删除书籍");
                System.out.println("5.退出");
                System.out.print("请输入：");
                int respond = scanner.nextInt();
                switch (respond) {
                    case 1:
                        add();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        modify();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        System.out.println("正在保存信息");
                        save();
                        return;
                }
            }

        }

        private static void load() {
            File file = new File("test.txt");
            if (file.exists()) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"))) {
                    LIST = (List<Book>) in.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                LIST = new LinkedList<>();
            }
        }
        private static void save(){
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt"))){
                out.writeObject(LIST);
                out.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        private static void add(){
            scanner.nextLine();
            System.out.print("请输入书籍名称：");
            String s1 = scanner.nextLine();
            System.out.print("请输入书籍的作者：");
            String s2 = scanner.nextLine();
            System.out.print("请输入书籍价格：");
            int s3 = scanner.nextInt();

            Book book = new Book(s1,s2,s3);
            LIST.add(book);
            System.out.println("书籍添加成功！");
            scanner.nextLine();
        }
        private static void search(){
            if (LIST.size() ==0)
                System.out.println("图书馆暂时没有书籍!");
            for (int i = 0;i < LIST.size();i++){
                System.out.println(i + " " + LIST.get(i));
            }

        }
        private static void modify(){
            System.out.print("请输入要修改的书籍编号：");
            int index = scanner.nextInt();
            scanner.nextLine();
            if (index > LIST.size() - 1 || index < 0){
                System.out.println("输入有误，请重新输入");
            } else {
                Book book = LIST.get(index);
//            String content = "";
//            int price = 0;

                System.out.print("请输入修改后的书名：");
//            content = scanner.nextLine();
//            book.setName(content);
                book.setName(scanner.nextLine());

                System.out.print("请输入修改后的作者：");
//            content = scanner.nextLine();
//            book.setAuthor(content);
                book.setAuthor(scanner.nextLine());

                System.out.print("请输入修改后的价格：");
//            price = scanner.nextInt();
//            book.setPrice(price);
                book.setPrice(scanner.nextInt());
                System.out.println("修改成功");
            }
        }
        private static boolean delete(){
            scanner.nextLine();
            System.out.print("请输入要删除的书籍编号");
            int index = scanner.nextInt();
            if (index >= LIST.size() - 1 || index <= 0){
                System.out.println("输入有误");
                return false;
            }
            LIST.remove(index);
            System.out.println("删除成功");
            return true;
        }
}

