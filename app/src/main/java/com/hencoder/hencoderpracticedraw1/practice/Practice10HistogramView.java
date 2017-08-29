package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private Paint linePaint = new Paint();
    private static final int DEF_STEP = 100;

    private List<RectFWrap> rectFs;

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        rectFs = new ArrayList<>();
        rectFs.add(new RectFWrap(new RectF(50, 150, 50 + DEF_STEP, 550), paint));
        //
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        rectFs.add(new RectFWrap(new RectF(50 + DEF_STEP, 250, 50 + DEF_STEP * 2, 550), redPaint));
        //
        Paint bluePaint = new Paint();
        bluePaint.setColor(Color.BLUE);
        rectFs.add(new RectFWrap(new RectF(50 + DEF_STEP * 2, 175, 50 + DEF_STEP * 3, 550), bluePaint));


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int size = rectFs.size();
        for (int i = 0; i < size; i++) {
            canvas.drawRect(rectFs.get(i).getRectF(), rectFs.get(i).getPaint());
        }
        canvas.drawLine(0, 550, 550, 550, linePaint);
    }

    private class RectFWrap {
        RectF rectF;
        Paint paint;

        RectFWrap(RectF rectF, Paint paint) {
            this.rectF = rectF;
            this.paint = paint;
        }

        RectF getRectF() {
            return rectF;
        }

        public void setRectF(RectF rectF) {
            this.rectF = rectF;
        }

        Paint getPaint() {
            return paint;
        }

        public void setPaint(Paint paint) {
            this.paint = paint;
        }
    }
}
