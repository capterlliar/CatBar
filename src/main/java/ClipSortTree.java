class node{
    int num;
    int val;
}

public class ClipSortTree {
    node[] tr;

    ClipSortTree(int n){
        tr=new node[n*4];
        init(1,1,n);
    }

    public void pushup(int now){
        if(tr[now*2].val<=tr[now*2+1].val){
            tr[now].num=tr[now*2].num;
            tr[now].val=tr[now*2].val;
        }
        else{
            tr[now].num=tr[now*2+1].num;
            tr[now].val=tr[now*2+1].val;
        }
    }

    public void init(int now, int l, int r){
        tr[now]=new node();
        if(l==r){
            tr[now].num=l;
            tr[now].val=0;
            return;
        }
        int mid=(l+r)/2;
        init(now*2,l,mid);
        init(now*2+1,mid+1,r);
        pushup(now);
    }

    public void modify(int now,int l,int r,int x,int val){
        if(l==r){
            tr[now].val=val;
            return;
        }
        int mid=(l+r)/2;
        if(x<=mid) modify(now*2,l,mid,x,val);
        else modify(now*2+1,mid+1,r,x,val);
        pushup(now);
    }

    public int query(){
        return tr[1].val == Priority.FIXED ? -1 : tr[1].num;
    }
}
//
