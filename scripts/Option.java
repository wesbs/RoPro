package scripts;

import java.io.*;
import java.lang.String;
import java.util.*;

public class Option {
	// types of options
	public static final int SELECT = 0;
	public static final int NUM = 1;
	public static final int PATH = 2;
	public static final int NOARG = 3;
	public static final int LIST = 4;
	public static final int INPUT = 5;


	private String label;										// one or two word label to describe option
	private String flag; 										// the flag to enter in command line 
	private int type; 											// option type -> one of three above
	private String desc;										// description of option
	private List<String> selections;				// for select type -> selection options, for type path with > 1 files -> List of paths
	private int selected;										// for select type -> index of option selected : otherwise -1, for path type -> num of files
	private float value;										// for number type -> value selected
	private String path;										// for path type -> path selected; for input type -> input string
	private boolean on;											// for NOARG type -> tells whether to use or not

	// if type -> path and selected = 0 -> means varibale num of files

	public Option(){}
	public Option(String label, String flag, int type, String desc){
		this.label = label;
		this.flag = flag;
		this.type = type;
		this.desc = desc;
		this.selected = -1;
		this.value = -1;
		if (this.type == NOARG)
			this.on = false;
		else
			this.on = true;
	}

	public Option(String label, String flag, int type, boolean def, String desc){
		this.label = label;
		this.on = def;			// def is usually true
		this.flag = flag;
		this.type = type;
		this.desc = desc;
		this.selected = -1;
		this.value = -1;
	}

	public Option(String label, String flag, int type, int numOfFiles, String desc){
		this.label = label;
		this.flag = flag;
		this.type = type;
		this.desc = desc;
		System.out.println("Created Option: " + numOfFiles);
		this.selected = numOfFiles;
		this.selections = (numOfFiles == 0 ? new ArrayList<String>() : new ArrayList<String>(numOfFiles));
		if (numOfFiles != 0){
			for (int i = 0; i < numOfFiles; i++)
				this.selections.add("");
		}
		this.value = -1;
		if (this.type == NOARG)
			this.on = false;
		else
			this.on = true;
	}
	public Option(String label, String flag, int type, List<String> selections, String desc){
		this.label = label;
		this.flag = flag;
		this.type = type;
		this.desc = desc;
		this.on = true;
		this.selections = selections;
		this.selected = -1;
	}

	public Option(String label, String flag, int type, List<String> selections, int def, String desc){
		this.label = label;
		this.flag = flag;
		this.type = type;
		this.desc = desc;
		this.selections = selections;
		this.selected = def;
		this.on = true;
	}
	// public Option(String flag, int type, int value){
	// 	this.flag = flag;
	// 	this.type = type;
	// 	this.value = value;
	// }
	// public Option(String flag, int type, String path){
	// 	this.flag = flag;
	// 	this.type = type;
	// 	this.path = path;
	// }

	public static String intString(float f){
	  int holder = (int) f;
	  String ret;
	  System.out.println("Intial: " + f + "; Holder: " + holder);
	  if (holder == f){
	      System.out.println("Holder = Initial");
	      ret = Integer.toString(holder);
	  }
	  else{
	      System.out.println("Holder != Initial");
	      ret = Float.toString(f);
	  }
	  return ret;
  }


	// returns the flag
	public String getLabel(){
		return this.label;
	}

	// returns the flag
	public String getFlag(){
		return this.flag;
	}

	// returns the type
	public int getType(){
		return this.type;
	}

	// returns description
	public String getDescription(){
		return this.desc;
	}

	// returns the Selection list if of type SELECT
	// otherwise returns null
	public List<String> getSelections(){
		if (this.type != SELECT)
			return null;
		else
			return this.selections;
	}

	// returns the list if of type LIST
	// otherwise returns null
	public List<String> getList(){
		if (this.type != LIST)
			return null;
		else
			return this.selections;
	}

	// sets the list of selections if of type SELECT
	// otherwise does nothing
	public void setSelections(List<String> selections){
		if (this.type == SELECT)
			this.selections = selections;
	}

	// sets the list if of type LIST
	// otherwise does nothing
	public void setList(List<String> list){
		if (this.type == LIST)
			this.selections = list;
	}

	// returns the value if of type NUM
	// otherwise returns -1
	public float getValue(){
		if (this.type != NUM)
			return -1;		// might casue some problems casue value could be -1
		else
			return this.value;
	}

	// sets the value if of type NUM
	// otherwise does nothing
	public void setValue(float value){
		if (this.type == NUM)
			this.value = value;
	}

	public void setInput(String s){
		System.out.println("HEEERRRRR");
		if (this.type == INPUT){
			this.path = s;
			System.out.println(this.path);
		}
	}

	public String getInput(){
		if (this.type == INPUT)
			return this.path;
		else 
			return null;
	}

	// adds a file for PATH and numFiles > 1 or = 0
	public void addFile(int index, String path){
		if (this.type == PATH && this.getNumFiles() != 1){
			this.selections.set(index, path);
		}
	}

	// returns the index of the selected option if of type SELECT
	// otherwise, returns -1
	public int getSelectedIndex(){
		if (this.type != SELECT)
			return -1;		// might casue some problems casue value could be -1
		else
			return this.selected;
	}

	// returns the string of the selected option if of type SELECT and a valid index
	// otherwise , returns null
	public String getSelected(){
		if (this.type != SELECT || (this.selected < 0 || this.selected >= this.selections.size()))
			return null;
		else
			return this.selections.get(this.selected);
	}

	public boolean getOn(){
		return this.on;
	}

	public int getNumFiles(){
		if (this.type != PATH)
			return -1;
		else 
			return (this.selected == -1 ? 1 : this.selected);
	}

	// sets the index of the selected option if of type SELECT
	// otherwise, sets selected to -1 (an invalid index)
	public void setSelected(int value){
		if (this.type == SELECT)
			this.selected = value;
		else
			this.selected = -1;
	}

	public boolean setSelected(String sel){
		if (this.type == SELECT){
			for (int i = 0; i < this.selections.size(); i++){
				if (this.selections.get(i).equals(sel)){
					this.selected = i;
					return true;
				}
			}
			this.selected = -1;
			return false;
		}
		else
			this.selected = -1;
		return false;
	}

	// returns the path if of type PATH
	// otherwise, returns null
	public String getPath(){
		if (this.type != PATH)
			return null;
		else
			return this.path;
	}

	// sets the path if of type PATH
	// otherwise, does nothing
	public void setPath(String path){
		if (this.type == PATH)
			this.path = path;
	}

	// turn on option
	public void turnOn(){
		this.on = true;
	}

	// turn off option
	public void turnOff(){
		this.on = false;
	}

	// for type PATH and varibale amount of files
	public void addFile(String path){
		if (this.type == PATH && this.getNumFiles() == 0){
			this.selections.add(path);
		}
	}

	// for tpye PATH and varibale amount of files
	public boolean removeFile(String path){
		if (this.type == PATH && this.getNumFiles() == 0){
			return this.selections.remove(path);
		}
		return false;
	}

		// for tpye PATH and varibale amount of files
	public void removeFile(int index){
		if (this.type == PATH && this.getNumFiles() == 0){
			this.selections.remove(index);
		}
	}

	// private function to make sure selections is filled out
	private boolean listFull(int size){
		for (int i =0 ; i < size; i++){
			try {
				if (this.selections.get(i).equals(""))
					return false;
			} catch (NullPointerException e) {
				return false;
			}
		}
		return true;
	}

	// returns true if option has an argument that allows it to be runnable
	// returns false if option is not ready to be run
	public boolean isRunnable(){
		if (this.on){
			switch (this.type){
				case SELECT:
					if (this.selected >= 0 && this.selected < this.selections.size())
						return true;
					break;
				case NUM:
					if (this.value != -1)
						return true;
					break;
				case PATH:
					if (this.getNumFiles() == 1){
						if (this.path != null && !this.path.equals(""))
							return true;
					}
					else if (this.getNumFiles() != 0){
						if (listFull(this.getNumFiles()))
							return true;
					}
					else {
						// do something
						if (this.selections.size() > 0)
							return true;
					}
					break;
				case NOARG:
					if (this.on)
						return true;
					break;
				// case LIST:
				// 	if ()
				case INPUT:
					if (this.path != null && !this.path.equals(""))
						return true;
					break;
			}
		}
		return false;
	}

	// returns the string format of the options
	// of the format "<flag> <argument>"
	public String optionString(){
		String retString = "";
		switch (this.type){
			case SELECT:
				if (this.selected >= 0 && this.selected < this.selections.size())
					retString = flag + " " + this.selections.get(this.selected);
				break;
			case NUM:
				retString = flag + " " + this.value;
				break;
			case PATH:
				if (this.getNumFiles() == 1 && this.path != null)
					retString = flag + " " + this.path;
				else if (this.getNumFiles() > 1){
					StringBuilder sb = new StringBuilder(flag + " " + this.selections.get(0));
					for (int i = 1; i < this.getNumFiles(); i++)
						sb.append("," + this.selections.get(i));
					retString = sb.toString();
				}
				else {
					// do something
					StringBuilder sb = new StringBuilder(flag + " ");
					if (this.selections.size() > 0){
						for (int i = 0; i < this.selections.size(); i++)
							sb.append("," + this.selections.get(i));
					}
					retString = sb.toString();
				}
				break;
			case NOARG:
				retString = this.getFlag();
				break;
			// case LIST:
			// 	StringBuilder list = new StringBuilder();
			// 	list.append(this.flag + " ");
			// 	for (int i = 0; i < this.selections.size()-1; i++){
			// 		list.append(this.selections.get(i) + ", ");
			// 	}
			// 	list.append(this.selections.get(this.selections.size()-1));
			// 	retString = list.toString();
			// 	break;
			case INPUT:
				retString = this.getFlag() + " " + this.getInput();
				break;
		}
		return retString;
	}

	// returns the argument for all types of options except NOARG
	// for NOARG, returns null
	public String getArgument(){
		String arg = "";
		switch (this.type){
			case SELECT:
				if (this.selected >= 0 && this.selected < this.selections.size())
					arg = this.selections.get(this.selected);
				break;
			case NUM:
				arg = intString(this.value);
				break;
			case PATH:
				if (this.getNumFiles() == 1)
					arg = this.path;
				else {
					StringBuilder list = new StringBuilder();
					for (int i = 0; i < this.selections.size()-1; i++){
						list.append(this.selections.get(i) + ",");
					}
					list.append(this.selections.get(this.selections.size()-1));
					arg = list.toString();
				}
				break;
			case NOARG:
				arg = null;
				break;
			case LIST:
				break;
			case INPUT:
				arg = this.getInput();
				break;
		}
		return arg;
	}

	// returns a list of strings containg option contents
	// list[0] is the flag, list[1] is the argument (for all types except NOARG)
	public List<String> optionStringList(){
		List<String> opList = new ArrayList<String>();
		opList.add(this.flag);
		switch (this.type){
			case SELECT:
				if (this.selected >= 0 && this.selected < this.selections.size())
					opList.add(this.selections.get(this.selected));
				break;
			case NUM:
				opList.add(Float.toString(this.value));
				break;
			case PATH:
				opList.add(this.path);
				break;
			case NOARG:
				break;
			case LIST:
				for (int i = 0; i < this.selections.size()-1; i++){
					opList.add(this.selections.get(i) + ", ");
				}
				opList.add(this.selections.get(this.selections.size()-1));
				break;
		}
		return opList;
	}

	// returns a string of deatils about the option
	// includes flag, type, selections (for SELECT), and the argument
	public String toString(){
		String toRet = "Flag: " + this.flag + "; Type: " + (this.type == SELECT ? "Selection;" : (this.type == NUM ? "Number;" : (this.type == NOARG ? "No Arg;" : "File;")));
		switch (type){
			case SELECT:
				toRet.concat(" Options: ");
				for (int i = 0 ; i < this.selections.size(); i++){
					toRet.concat(selections.get(i) + "; ");
				}
				break;
			case NUM:
				toRet.concat(" Value: " + (this.value == -1 ? "Not Entered" : this.value));
				break;
			case PATH:
				toRet.concat(" Path: " + (this.path == null ? "Not Entered" : this.path));
			case NOARG:
				break;
			case LIST:
				break;
		}
		return toRet;
	}

	// public static void main(String args[]){
	// 	Option op = new Option("-i", PATH);
	// 	op.setPath("/home/linuxbin/emacsimdir/bin/");
	// 	op.setValue(35);
	// 	List<String> ss = new ArrayList<String>();
	// 	ss.add("Elephant");
	// 	ss.add("Dog");
	// 	ss.add("Horse");
	// 	op.setSelections(ss);
	// 	op.setSelected(0);
	// 	System.out.println(op.toString());
	// 	System.out.println(op.optionString());
	// }
}