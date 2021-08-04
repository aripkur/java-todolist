public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }


    /**
     *Menampilkan todolist
     */
    public static void showTodoList(){
        System.out.println("========== TODOLIST =========");
        for ( var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
        System.out.println("============================");
    }
    public static void testShowTodoList(){
        model[0] = "lala";
        model[1] = "lala1";
        showTodoList();
     }

    /**
     * Menambah todo dari list
     */
    public static void addTodoList(String todo){
        var penuh = true;
        for ( var i = 0; i < model.length; i++){
            if(model[i] == null){
                penuh = false;
                break;
            }
        }
        if (penuh){
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }
    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++){
            addTodoList("contoh todo ke "+ i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number){
        if(model.length <= (number - 1)){
            return false;
        }else if(model[number - 1] == null){
            return false;
        }else{
            model[number - 1] = null;
            for (int i = (number - 1); i < model.length; i++){
                if (i == (model.length - 1)){
                    model[i] = null;
                }else{
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        var result = removeTodoList(2);

        System.out.println(result);
        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println(".:MENU:.");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak tersedia");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("satu");
        addTodoList("satu");
        addTodoList("satu");
        addTodoList("satu");
        addTodoList("satu");
        viewShowTodoList();
    }
    /**
     * Menampilkan view menambah todolist
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAHKAN TODOLIST");

        var todo = input("Todo (x jika batal");
        if(todo.equals("x")){

        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("satu");
        viewAddTodoList();
        showTodoList();
    }    /**
     * Menampilkan view menghapus todolist
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var todo = input("Nomer yang dihapus (x Jika Batal)");

        if(todo.equals("x")){

        }else {
            boolean isSuccess = removeTodoList(Integer.valueOf(todo));
            if(!isSuccess){
                System.out.println("Gagal menghapus todo : " + todo);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("satu");
        addTodoList("satu");
        addTodoList("satu");
        addTodoList("satu");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
