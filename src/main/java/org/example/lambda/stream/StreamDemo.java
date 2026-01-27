package org.example.lambda.stream;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(Author::getName)
                .map(StringBuilder::new)
                .map(sb->sb.append("-三更").toString())
                .forEach(System.out::println);

//        test22();
//        test21();
//        test20();
//        test19();
//        test18();
//        test17();
//        test16();
//        test15();
//        test14();
//        test13();
//        test12();
//        test11();
//        test10();
//        test09();
//        test08();
//        test07();
//        test06();
//        test05();
//        test04();
//        test03();
//        test02(authors);
//        test01(authors);
    }


    //findFirst 获取流中的第一个元素。
    //获取一个年龄最小的作家，并输出他的姓名。
    private static void test22() {
        List<Author> authors = getAuthors();
        Optional<Author> first = authors.stream()
                .sorted(Comparator.comparingInt(Author::getAge))
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    //findAny 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
    //获取任意一个年龄大于18的作家，如果存在就输出他的名字
    private static void test21() {
        List<Author> authors = getAuthors();
        Optional<Author> any = authors.stream()
                .filter(author -> author.getAge() > 10)
                .findAny();
        any.ifPresent(author -> System.out.println(author.getName()));
    }

    //noneMatch 可以判断流中的元素是否都不符合匹配条件。如果都不符合结果为true，否则结果为false
    //判断作家是否都没有超过100岁的。
    private static void test20() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);
    }

    //allMatch 可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。
    //判断是否所有的作家都是成年人
    private static void test19() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(b);
    }

    //anyMatch 可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。
    //判断是否有年龄在29以上的作家
    private static void test18() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 30);
        System.out.println(b);
    }

    //collect 把当前流转换成一个集合
    //获取一个Map集合，map的key为作者名，value为List<Book>
    private static void test17() {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> collect = authors.stream()
                .distinct()
                .collect(Collectors.toMap(new Function<Author, String>() {
                    @Override
                    public String apply(Author author) {
                        return author.getName();
                    }
                }, new Function<Author, List<Book>>() {
                    @Override
                    public List<Book> apply(Author author) {
                        return author.getBooks();
                    }
                }));
        System.out.println(collect);
    }

    //collect 把当前流转换成一个集合
    //获取一个所有书名的Set集合
    private static void test16() {
        List<Author> authors = getAuthors();
        Set<String> collect = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getName)
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    //collect 把当前流转换成一个集合
    // 获取一个存放所有作者名字的List集合。
    private static void test15() {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream()
                .map(Author::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    //max&min 可以用来或者流中的最值。
    //分别获取这些作家的所出书籍的最高分和最低分并打印
    private static void test14() {
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max((o1, o2) -> o1 - o2);
        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .min(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
        Integer i = max.get();
        Integer i1 = min.get();
        System.out.println(i);
        System.out.println(i1);
    }

    //可以用来获取当前流中元素的个数。
    //打印这些作家的所出书籍的数目，注意删除重复元素
    private static void test13() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    //终结操作，forEach()
//    输出所有作家的名字
    private static void test12() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);
    }

    //map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
    //打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
    private static void test11() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    //map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
    //打印所有书籍的名字。要求对重复的元素进行去重。
    private static void test10() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    //跳过流中的前n个元素，返回剩下的元素
    //打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
    private static void test09() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    //limit限制通过的数量
    //对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
    private static void test08() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    //sorted 可以对流中的元素进行排序 两种方法，一种是实体类实现Comparable，一种是写匿名内部类的方式
    //对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
    private static void test07() {
        List<Author> authors = getAuthors();
//        authors.stream()
//                .distinct()
//                .sorted()//实体类实现Comparable接口
//                .forEach(author -> System.out.println(author.getAge()));
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(author -> System.out.println(author.getAge()));

    }

    //distinct操作，记得重写equals()，不然需要两个对象地址一致
    //打印所有作家的姓名，并且要求其中不能有重复元素
    private static void test06() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    //map操作
    //把author对象转成Integer对象，并且年龄统一+10
    private static void test05() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(Author::getAge)
                .map(age -> age + 10)
                .forEach(System.out::println);
    }

    //filter操作
    //打印所有姓名长度大于1的作家的姓名
    private static void test04() {
        List<Author> authors = getAuthors();
        authors.stream()//就像函数里面传了一段代码
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 19);
        map.put("黑子", 17);
        map.put("日向翔阳", 16);
        //双列集合转换成单列集合后创建流对象
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        Set<String> strings = map.keySet();
//        Collection<Integer> values = map.values();
        Stream<Map.Entry<String, Integer>> stream = entries.stream();
        stream.distinct()
                .filter(new Predicate<Map.Entry<String, Integer>>() {
                    @Override
                    public boolean test(Map.Entry<String, Integer> stringIntegerEntry) {
                        return stringIntegerEntry.getValue() > 16;
                    }
                })
                .forEach(new Consumer<Map.Entry<String, Integer>>() {
                    @Override
                    public void accept(Map.Entry<String, Integer> stringIntegerEntry) {
                        System.out.println(stringIntegerEntry.getKey() + "===" + stringIntegerEntry.getValue());
                    }
                });
    }

    private static void test02(List<Author> authors) {
        //创建流对象
        //.Collection单列集合采用.stream()
//        Stream<Author> stream = authors.stream();

        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(arr);//采用数组工具类提供的方法去创建流对象
        Stream<Integer> stream2 = Stream.of(arr);//这个里面调用的还是Arrays.stream(arr)方法
        stream.distinct()
                .filter(integer -> integer > 2)
                .forEach(System.out::println);
    }

    private static void test01(List<Author> authors) {
        authors.stream()
                .distinct() //执行完还是流对象
                .filter(author -> author.getAge() < 18) //执行完还是流对象
                .forEach(author -> System.out.println(author.getName())); //没有终结操作流不会执行，此方法为终结方法
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
