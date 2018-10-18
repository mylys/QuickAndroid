package org.quick.library.callback;

import java.lang.System;

/**
 * * Created by jianghejie on 16/6/19.
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lorg/quick/library/callback/AppBarStateChangeListener;", "Landroid/support/design/widget/AppBarLayout$OnOffsetChangedListener;", "()V", "mCurrentState", "Lorg/quick/library/callback/AppBarStateChangeListener$State;", "onOffsetChanged", "", "appBarLayout", "Landroid/support/design/widget/AppBarLayout;", "i", "", "onStateChanged", "state", "State", "quick-library_debug"})
public abstract class AppBarStateChangeListener implements android.support.design.widget.AppBarLayout.OnOffsetChangedListener {
    private org.quick.library.callback.AppBarStateChangeListener.State mCurrentState;
    
    @java.lang.Override()
    public void onOffsetChanged(@org.jetbrains.annotations.NotNull()
    android.support.design.widget.AppBarLayout appBarLayout, int i) {
    }
    
    public abstract void onStateChanged(@org.jetbrains.annotations.NotNull()
    android.support.design.widget.AppBarLayout appBarLayout, @org.jetbrains.annotations.NotNull()
    org.quick.library.callback.AppBarStateChangeListener.State state);
    
    public AppBarStateChangeListener() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lorg/quick/library/callback/AppBarStateChangeListener$State;", "", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "IDLE", "quick-library_debug"})
    public static enum State {
        /*public static final*/ EXPANDED /* = new EXPANDED() */,
        /*public static final*/ COLLAPSED /* = new COLLAPSED() */,
        /*public static final*/ IDLE /* = new IDLE() */;
        
        State() {
        }
    }
}