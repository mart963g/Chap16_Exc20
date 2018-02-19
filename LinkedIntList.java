package Exc_20;

import java.util.NoSuchElementException;

public class LinkedIntList
{
    public ListNode front;

    public LinkedIntList()
    {
        this.front = null;
    }

    public void shift()
    {
        int size = 1;
        int count = 0;
        ListNode current = this.front;
        ListNode end = this.front;
        while(end.next!=null)
        {
            end = end.next;
            size++;
        }
        while(count<size/2)
        {

            end.next=current.next;
            current.next = current.next.next;
            end.next.next=null;
            current = current.next;
            end = end.next;
            count++;
        }
    }

    public void removeRange(int start,int end)
    {
        if(start<0||end<0)
        {
            throw new IllegalArgumentException();
        }
        ListNode head = front;
        ListNode back = front;
        int count = 0;
        while(count<end)
        {
            if(count<start-1)
            {
                back = back.next;
            }
            head = head.next;
            count++;
        }
        if(start==0)
        {
            front=head.next;
        } else
        {
            back.next = head.next;
        }
    }

    public boolean equals(LinkedIntList list)
    {
        ListNode current1 = this.front;
        ListNode current2 = list.front;
        while(current1!=null&&current2!=null)
        {
            if(current1.data!=current2.data)
            {
                return false;
            }
            if(current1.next==null&&current2.next!=null||current2.next==null&&current1.next!=null)
            {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public void stutter()
    {
        ListNode current = this.front;
        while(current!=null)
        {
            ListNode node = new ListNode(current.data,current.next);
            current.next = node;
            current = current.next.next;
        }
    }

    public void switchPairs()
    {
        ListNode head = this.front.next.next;
        ListNode middle = this.front.next;
        ListNode back = this.front;
        front = middle;
        back.next = head;
        middle.next = back;
        head = head.next;
        middle = middle.next.next;
        while(head!=null)
        {
            back.next = head;
            middle.next = head.next;
            head.next = middle;
            if(head.next.next==null)
            {
                break;
            }
            head = head.next.next.next;
            middle = middle.next;
            back = back.next.next;
        }

    }

    public int deleteBack()
    {
        if (front==null)
        {
            throw new NoSuchElementException();
        }
        ListNode current = front;
        while(current.next.next!=null)
        {
            current = current.next;
        }
        int value = current.next.data;
        current.next = null;
        return value;
    }

    public int countDuplicates()
    {
        int count = 0;
        ListNode current = front;
        while(current.next!= null)
        {
            if(current.data==current.next.data)
            {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public int lastIndexOf(int value)
    {
        int index = -1;
        ListNode current = front;
        int i = 0;
        while(current!=null)
        {
            if(current.data==value)
            {
                index = i;
            }
            i++;
            current = current.next;
        }
        return index;
    }

    public boolean isSorted()
    {
        boolean res = true;
        if(this.front==null)
        {
            return res;
        } else
        {
            ListNode current = this.front;
            while(current.next!=null)
            {
                if(current.data>current.next.data)
                {
                    res = false;
                }
                current = current.next;
            }
        }
        return res;
    }

    public int min()
    {
        int min = 0;
        if(this.front==null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            ListNode current = this.front;
            min = current.data;
            while(current!=null)
            {
                if(current.data<min)
                {
                    min = current.data;
                }
                current = current.next;
            }
        }
        return min;
    }

    public void set(int index,int value)
    {
        if(index==0)
        {
            this.front = new ListNode(value,front.next);
        } else
        {
            ListNode current = nodeAt(index-1);
            current.next = new ListNode(value,current.next.next);
        }
    }

    public void add(int i)
    {
        if(this.front==null)
        {
            this.front = new ListNode(i);
        } else
        {
            ListNode current = this.front;
            while(current.next!=null)
            {
                current = current.next;
            }
            current.next = new ListNode(i);
        }
    }

    public void add(int index, int value)
    {
        if(index==0)
        {
            this.front = new ListNode(value);
        } else
        {
            ListNode current = nodeAt(index);
            current.next = new ListNode(value,current.next);
        }
    }

    public void addSorted(int value)
    {
        if(this.front == null || this.front.data>=value)
        {
            this.front = new ListNode(value,front);
        } else
        {
            ListNode current = this.front;
            while(current.next != null && current.next.data<=value)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    public int get(int index)
    {
        ListNode current = nodeAt(index);
        return current.data;
    }

    private ListNode nodeAt(int index)
    {
        ListNode current = front;
        for(int i = 0;i<index;i++)
        {
            current = current.next;
        }
        return current;
    }

    public void remove(int index)
    {
        if(index==0)
        {
            front = front.next;
        } else
        {
            ListNode current = nodeAt(index-1);
            current.next = current.next.next;
        }
    }

    @Override
    public String toString()
    {
        if(this.front==null)
        {
            return "[]";
        } else
        {
            ListNode current = this.front.next;
            String str = "[" + this.front.data;
            while (current != null)
            {
                str += ", " + current.data;
                current = current.next;
            }
            str += "]";
            return str;
        }
    }

}
