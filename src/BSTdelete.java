import java.util.Scanner;

public class BSTdelete{
    static class Node{
        int key;
        Node left,right;
    };
    static Node newNode(int data){
        Node temp=new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    static Node insert(Node root,int key){
        Node newnode=newNode(key);
        Node x=root;
        Node currentparent=null;

        while(x!=null){
            currentparent=x;//Traverses the tree to find the correct position for the new node
            if(key<x.key){
                x=x.left;
            }
            else if(key>x.key){
                x=x.right;
            }
            else{
                System.out.println("Value already exists");
                return newnode;
            }
        }
        if(currentparent==null){ //After the loop, it determines whether to insert the new node 
            currentparent=newnode;
        }
        else if(key<currentparent.key){
            currentparent.left=newnode;
        }
        else{
            currentparent.right=newnode;
        }
        return currentparent;
    }
    static Node deleteNode(Node root,int key){
        return deleterecursive(root,key);
    }
    static Node deleterecursive(Node root,int key){
        if(root==null){
            return root;
        }
        if(key<root.key){
            root.left=deleterecursive(root.left,key);
        }
        else if(key>root.key){
            root.right=deleterecursive(root.right,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            root.key=minvalue(root.right);//if the node has two children
        }
        return root;
    }
    static int minvalue(Node root){
        int minval=root.key;
        while(root.left!=null){
            minval=root.left.key;
            root=root.left;
        }
        return minval;
    }
    static boolean search(Node root ,int key){
        root=searchrecursive(root,key);
        if(root!=null){
            return true;
        }
        else{
            return false;
        }
    }
    static Node searchrecursive(Node root,int key){
        if(root==null||root.key==key){
            return root;
        }
        if(root.key>key){
            return searchrecursive(root.left,key);
        }
        else{
            return searchrecursive(root.right,key);
        }}
        static void inorder(Node root){
            if(root==null){
                return;
            }
                inorder(root.left);
                System.out.println(root.key+"");
                inorder(root.right);
                }
        
    
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int value;
            boolean status;
            Node root=null;
            int [] arr={44,17,28,22,26,49,78,89,65,74,32,66};
            for(int i=0;i<arr.length;i++){
                value=arr[i];
            if(root==null){
                root=insert(root,value);
            }
            else{         
                insert(root,value);
            
            }}
        System.out.println("\ninorder binary tree!!.Root="+root.key);
        inorder(root);
        int stop=-1;
        while(stop!=0){
            System.out.println("enter the value to delete");
            int val=sc.nextInt();
            status=search(root,val);

            if(status==true){
                root=deleteNode(root,val);
                System.out.println("\n The inorder binary tree Root is"+root.key+"\n");
                System.out.println("Binary tree after deletion is:");
                inorder(root);
                System.out.println("\n Value found and deleted"+"\nEnter 0 to stop or any other Number  to continue");
                if(sc.nextInt()==0){
                    stop=0;
                }
                
            }
        }
        System.out.println("program completed");
        sc.close();//scanner close
    }}

        

    

    


