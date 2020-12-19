<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

/**
 * Class Move
 * @package App\Models
 *
 * @property ChessMatch $match
 */
class Move extends Model
{
    use HasFactory;

    protected $fillable = [
        'black',
        'white',
        'chess_match_id',
    ];

    /**
     * @return BelongsTo
     */
    public function chessMatch(): BelongsTo
    {
        return $this->belongsTo(ChessMatch::class, 'chess_match_id', 'id');
    }
}
