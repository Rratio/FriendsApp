package b.udacity.friendshipday;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.bumptech.glide.Glide;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FriendsAdapter adapter;
    private List<Friends> albumList;
    String name;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         toolbar = (Toolbar) findViewById(R.id.toolbar);
         toolbar.setTitle("Friends Diary");
         setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new FriendsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.rijwan,
                R.drawable.surbhi,
                R.drawable.shreya,
                R.drawable.vikky,
                R.drawable.vipul,
                R.drawable.vinod,
                R.drawable.goutam,
                R.drawable.shalini,
                R.drawable.ronak,
                R.drawable.poonam,
                R.drawable.muskan,
                R.drawable.leediyal,};

        String[] mDesc = new String[]{
                "He is one of my Best Friend who always helps me or understand me. \n" +
                        "Hum jite har baazi to mashhur ho gye,\n" +
                        "teri hansi me hanse to gum dur ho gye, \n" +
                        "bus ek Aap jaise ki badolat hum tute hue kanch se kohinoor ho gye.",
                 "She is the one who always behind me whenever i'm in trouble. \n" +
                         "Din aate hai, Din jate hai... \n" +
                         "Kuch lamhe Aap ke bin guzar nahi pate hai.\n" +
                         "Inhi lamho ko samet k dekhu, \n" +
                         "to aap jaise nalayak dost bhut yaad aate H.",
                 "Hasna Hasana kisko gwara nhi hota, \n" +
                         "har muskil jindagi ka shara nhi hota... \n" +
                         "Milte h log is janha zindagi me \n" +
                         "par har dost tumsa pyara nhi hota.",
                  "One of my different Friend, \n" +
                          "Ae Dost teri dosti ke liye, duniya chod denge... \n" +
                          "hum teri taraf aaye har toofan ko mod denge. \n" +
                          "lekin tumne jo sath choda.... \n" +
                          "kasam se teri haddiya tod denge.",
                  "He is always ready to help everyone. \n" +
                           "Hum dua karte h khuda se...\n" +
                           "ki vo aap jaisa dost or na banaye, \n" +
                           "Ek hi cartoon jaisi cheez h hmare pass... \n" +
                           "Kahi vo bhi common na ho jaye. \n",
                  "Andhere main rishta nibhana muskil hota hai.. \n" +
                          "Tufan me dipak jalana muskil hota hai, \n" +
                          "dosti kisi se bhi karna muskil nahi... \n" +
                          "Magar isse nibhana bada muskil hota hai.",
                  "My team member and never say no to anyone. \n" +"" +
                          "Kis had tak jana h ye kon janta h... \n" +
                          "kis manzil ko pana h yeh kon janta h, \n" +
                          "Dosti ke do pal ji bhar ke ji lo.. \n" +
                          "kis roj bichad jana h ye kon janta h.",
                  "She is my roommate and my crime partner. \n" +"" +
                          "I don't need words to express, \n" +
                          "I don't need tears to shed, \n" +
                          "I don't need to ask for a smile, \n" +"" +
                          "Or a hand to hold me... \n" +
                          "All I need is to be your friend, forever.",
                  "We all met as strangers,\n" +
                          "And became friends....\n" +
                          "Now will always be together,\n" +
                          "As our friendship will never end.",
                   "She is craziest person in my life.... \n" +
                           "Mangi thi dua humne Rab se... \n" +
                           "Dena muje dost jo alg ho sabse, \n" +
                           "usne mila dia hme apse or kaha... \n" +
                           "Sambhalo inhe ye anmol hai sab se.",
                   "She is my new friend and abnd Scholar in GIS Community, \n" +
                           "She is really sweet in nature.",
                    "She is the first friend in my GIS community, \n" +"" +
                            "very supportive and encourage me to connect everyone",};

        Friends a = new Friends("Rijwan Khan",mDesc[0], covers[0]);
        albumList.add(a);

        a = new Friends("Surbhi vyas",mDesc[1],  covers[1]);
        albumList.add(a);

        a = new Friends("Shreya Jain",mDesc[2], covers[2]);
        albumList.add(a);

        a = new Friends("Vikas Ameta",mDesc[3], covers[3]);
        albumList.add(a);

        a = new Friends("Vipul Jain",mDesc[4], covers[4]);
        albumList.add(a);

        a = new Friends("Vinod Tak", mDesc[5], covers[5]);
        albumList.add(a);

        a = new Friends("Goutam devra", mDesc[6],covers[6]);
        albumList.add(a);

        a = new Friends("Shalini Lahoti",mDesc[7],  covers[7]);
        albumList.add(a);

        a = new Friends("Ronak Rathi",mDesc[8] ,covers[8]);
        albumList.add(a);

        a = new Friends("Poonam",mDesc[9] ,covers[9]);
        albumList.add(a);

        a = new Friends("Muskan.abnd",mDesc[10] ,covers[10]);
        albumList.add(a);

        a = new Friends("Leediyal.fend",mDesc[11] ,covers[11]);
        albumList.add(a);


        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    }






