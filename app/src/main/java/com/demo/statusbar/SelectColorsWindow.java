package com.demo.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by xiangcheng on 16/9/13.
 */
public class SelectColorsWindow extends PopupWindow {
    private Context context;
    private RelativeLayout mainBack;
    private GridView container;
    private SelectColorsAdapter selectColorsAdapter;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private OnItemClickListener listener;


    public SelectColorsWindow(Context context, int checked, final List<OnItemClickListener> listeners, final Resources.Theme theme) {
        super(context);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.select_colors_layout, null);
        setContentView(view);
        mainBack = (RelativeLayout) view.findViewById(R.id.main_back);
        view.findViewById(R.id.top_back).getBackground().setAlpha(100);
        container = (GridView) view.findViewById(R.id.container);
        view.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectColorsAdapter != null) {
                    if (SelectColorsWindow.this.listener != null) {
                        SelectColorsWindow.this.listener.setMyTheme(selectColorsAdapter.getChecked());
                        SelectColorsWindow.this.listener.ItemClick(theme);
                    }
                    if (listeners != null && listeners.size() > 0) {
                        for (OnItemClickListener onItemClickListener : listeners) {
                            onItemClickListener.setMyTheme(selectColorsAdapter.getChecked());
                            onItemClickListener.ItemClick(theme);
                        }

                    }
                    dismiss();
                }
            }
        });
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        this.setBackgroundDrawable(dw);
        setAnimationStyle(R.style.MenuPop);

        view.findViewById(R.id.top_back).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int height = mainBack.getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }

        });
        createColors(checked);
    }

    private void createColors(int checked) {
        int[] colors = context.getResources().getIntArray(R.array.colors);
        selectColorsAdapter = new SelectColorsAdapter(colors, checked);
        container.setAdapter(selectColorsAdapter);
    }

    class SelectColorsAdapter extends BaseAdapter {

        int[] colors;
        ViewGroup.LayoutParams params;
        RelativeLayout.LayoutParams paramsImg;

        public int getChecked() {
            return checked;
        }

        int checked;

        SelectColorsAdapter(int[] colors, int checked) {
            this.colors = colors;
            this.checked = checked;
            params = new ViewGroup.LayoutParams(120, 120);
            paramsImg = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }


        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public Object getItem(int position) {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(R.mipmap.test_passed);
            relativeLayout.setLayoutParams(params);
            View view = new View(context);
            view.setLayoutParams(params);
            view.setBackground(DrawableUtis.createShape(colors[position]));
            relativeLayout.addView(view);
            paramsImg.addRule(RelativeLayout.CENTER_IN_PARENT);
            relativeLayout.addView(imageView, paramsImg);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checked = position;
                    notifyDataSetChanged();
                }
            });
            if (position == checked) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }
            return relativeLayout;
        }


    }

    public static interface OnItemClickListener {
        void ItemClick(Resources.Theme theme);

        View getView();

        void setMyTheme(int index);

    }
}
