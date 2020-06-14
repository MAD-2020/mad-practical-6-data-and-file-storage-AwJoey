package sg.edu.np.week_6_whackamole_3_0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class CustomScoreAdaptor extends RecyclerView.Adapter<CustomScoreViewHolder> {
    /* Hint:
        1. This is the custom adaptor for the recyclerView list @ levels selection page

     */
    private static final String FILENAME = "CustomScoreAdaptor.java";
    private static final String TAG = "Whack-A-Mole3.0!";
    UserData user;
    ArrayList<Integer> levels;
    ArrayList<Integer> scores;

    public CustomScoreAdaptor(UserData userdata){
        user = userdata;
        levels = user.getLevels();
        scores = user.getScores();

        /* Hint:
        This method takes in the data and readies it for processing.
         */
    }

    public CustomScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View user = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.level_select, parent, false);
        return new CustomScoreViewHolder(user);
        /* Hint:
        This method dictates how the viewholder layuout is to be once the viewholder is created.
         */
    }

    public void onBindViewHolder(CustomScoreViewHolder holder, final int position){

        final Integer levelPos = levels.get(position);
        holder.level.setText("Level " + levelPos);

        final Integer scorePos = scores.get(position);
        holder.score.setText("Highest Score: " + scorePos);

        Log.v(TAG, FILENAME + " Showing level " + levelPos + " with highest score: " + scorePos);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Main4Activity.class);
                intent.putExtra("username", user.getMyUserName());
                intent.putExtra("level", levelPos);
                intent.putExtra("score", scorePos);
                v.getContext().startActivity(intent);
                Log.v(TAG, FILENAME+ ": Load level " + position +" for: " + user.getMyUserName());
           }
       });

        /* Hint:
        This method passes the data to the viewholder upon bounded to the viewholder.
        It may also be used to do an onclick listener here to activate upon user level selections.

        Log.v(TAG, FILENAME + " Showing level " + level_list.get(position) + " with highest score: " + score_list.get(position));
        Log.v(TAG, FILENAME+ ": Load level " + position +" for: " + list_members.getMyUserName());
         */
    }

    public int getItemCount(){
        return levels.size();
        /* Hint:
        This method returns the the size of the overall data.
         */
    }
}