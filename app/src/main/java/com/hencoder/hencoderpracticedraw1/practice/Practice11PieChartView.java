package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

    private List<ChartData> chartDataList;
    private RectF rectF;

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //this is the main constructor method;
    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (null == chartDataList) {
            chartDataList = new ArrayList<>();
        }
        rectF = new RectF(100, 100, 350, 350);
        chartDataList.add(new ChartData(Color.RED, "1", 150));
        chartDataList.add(new ChartData(Color.YELLOW, "2", 200));
        chartDataList.add(new ChartData(Color.BLUE, "3", 220));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        if (null == chartDataList) {
            return;
        }
        float startAngle = 0;
        int size = chartDataList.size();
        for (int i = 0; i < size; i++) {
            float sweepAngle = chartDataList.get(i).getAmount() / (150 + 200 + 220)*360;
            canvas.drawArc(rectF, startAngle, sweepAngle, true,chartDataList.get(i).getPaint());
            startAngle += sweepAngle;
        }
    }

    class ChartData {
        private int color;
        private String name;
        private float amount;
        private Paint paint;

        public Paint getPaint() {
            if (null == paint)
                paint = new Paint();
            paint.setColor(color);
            return paint;
        }

        public ChartData(int color, String name, float amount) {
            this.color = color;
            this.name = name;
            this.amount = amount;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
