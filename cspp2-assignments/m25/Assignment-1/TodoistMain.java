import java.util.*;
/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                // case "print-todoist":
                //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
               // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        //try {
        	//System.out.println();
        return new Task(title, assignedTo, timeToComplete, important, urgent, status);
        //} catch (Exception e) {
        	//System.out.println(e.getMessage());
        	//return null;
        	// return Task(title, assignedTo, timeToComplete, important, urgent, status);
        	// return Task(null);
        //}
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
class Task {
	String title, assignedTo, status;
	int timeToComplete;
	boolean important, urgent;
	Task(String title, String assignedTo, int timeToComplete, boolean important,
		boolean urgent, String status) throws Exception  {
		//System.out.println(toString());
		if (title.length() == 0) {
			throw new Exception("Title not provided");	
		} else {
			this.title = title;
		}
		this.assignedTo = assignedTo;
		if (timeToComplete >= 0) {
			this.timeToComplete = timeToComplete;
		} else {
			throw new Exception("Invalid timeToComplete " + timeToComplete);		
		}
		//System.out.println(getImportance()); 
		this.important = important; 
		//this.important = important;
		this.urgent = urgent;
		if (status == "todo" || status == "done") {
			this.status = status;
		} else {
			throw new Exception("Invalid status " + status);
		}
		//return Task(this.title,this.assignedTo,this.timeToComplete,this.important, this.urgent,this.status);
		//System.out.println(toString());
	}
	public  String getImportance() {
		String imp;
		if (this.important) {
			imp = "Important";
	    } else {
	    	imp = "Not Important";
	    }
	    return imp;
	}
	public  String getUrgency() {
		String urgent;
		if (this.urgent) {
			urgent = "Urgent";
	    } else {
	    	urgent = "Not Urgent";
	    }
	    return urgent;

	}
	public String getStatus() {
		return this.status;
	}
	public String getassignedTo() {
		return this.assignedTo;
	}
	public int gettimeToComplete() {
		return this.timeToComplete;
	}
	public String getTitle() {
		return this.title;
	}
	public String toString() {
		String s = "";
		s += this.title + ", " + this.assignedTo + ", " + this.timeToComplete;
		if (this.important) {
			s += ", " + "Important";
		} else {
			s += ", " + "Not Important";
		}
		if (this.urgent) {
			s += "," + "Urgent";
		} else {
			s += ", " + "Not Urgent";
		} 
		s += ", " + this.status;
		return s;
	}
}

class Todoist {
	Task[] task;
	int size;
	Todoist() {
		task = new Task[20];
		size = 0;
	}
	public void addTask(Task obj) {
		if (size == task.length) {
			resize();
		} else {
			task[size++] = obj;
		}
	}
	private void resize() {
		task = Arrays.copyOf(task, task.length * 2);
	}

	public String toString() {
		String a = "";
		int i;
		for (i = 0; i < size - 1; i++) {
			a += task[i].getTitle() + ", " + task[i].getassignedTo() + ", " + task[i].gettimeToComplete() + ", " +  task[i].getImportance();
			a += ", " + task[i].getUrgency() + ", " + task[i].getStatus();
			a += "\n";
		}
		a += task[i].getTitle() + ", " + task[i].getassignedTo() + ", " + task[i].gettimeToComplete() + ", " + task[i].getImportance();
		a += ", " + task[i].getUrgency() + ", " + task[i].getStatus();
		return a;
	}
}
// 	public Task getNextTask(String name) {

// 	}
// 	public Task[] getNextTask(String name, int count) {

// 	}
// 	public 
// }
