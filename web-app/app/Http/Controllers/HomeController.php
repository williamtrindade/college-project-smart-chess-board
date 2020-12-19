<?php

namespace App\Http\Controllers;

use App\Models\ChessMatch;
use Illuminate\Contracts\Foundation\Application;
use Illuminate\Contracts\View\Factory;
use Illuminate\Contracts\View\View;

class HomeController extends Controller
{
    public function index(): Factory|View|Application
    {
        /** @var ChessMatch $model */
        $model = app(ChessMatch::class);
        return view('welcome', [
            'chess_matches' => $model->newQuery()
                ->orderBy('id', 'desc')
                ->get()
        ]);
    }
}
