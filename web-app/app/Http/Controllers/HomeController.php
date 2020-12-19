<?php

namespace App\Http\Controllers;

use App\Models\ChessMatch;

class HomeController extends Controller
{
    public function index()
    {
        return view('welcome', ['chess_matches' => ChessMatch::all()]);
    }
}
