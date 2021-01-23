package com.example.aucschedd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    List<Assignment> assignmentList;

    public AssignmentAdapter(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder{

        TextView tvAssignment;
        TextView tvDue;
        TextView tvDetails;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAssignment = itemView.findViewById(R.id.tv_assignmentName);
            tvDue = itemView.findViewById(R.id.tv_due);
            tvDetails = itemView.findViewById(R.id.tv_details);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            expandableLayout = itemView.findViewById(R.id.expandablelayout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Assignment assignment = assignmentList.get(getAdapterPosition());
                    assignment.setExpandable(!assignment.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }

    @NonNull
    @Override
    public AssignmentAdapter.AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_line, parent, false);
        return new AssignmentViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentAdapter.AssignmentViewHolder holder, int position) {
        Assignment assignment = assignmentList.get(position);

        holder.tvAssignment.setText(assignment.getCourseName() + " Assignment");
        holder.tvDetails.setText(assignment.getDetails());
        holder.tvDue.setText(Integer.toString(assignment.getDueDay()) + "/" + Integer.toString(assignment.getDueMonth()) + "/" + assignment.getDueYear());

        boolean isExpandable = assignmentList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);



    }

    @Override
    public int getItemCount() {
        return this.assignmentList.size();
    }
}
